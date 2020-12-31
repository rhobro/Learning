package main

import (
	"encoding/json"
	"flag"
	"fmt"
	"io/ioutil"
	"math/rand"
	"net/http"
	"os"
	"strings"
	"time"
)

var sym string
var mode string
var outputFName string

var validModes []string

const randStrChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY0123456789"

var rd rand.Rand

func init() {
	flag.StringVar(&sym, "s", "unspecified",
		"Argument for the ticker symbol of the stock you want the data for.")
	flag.StringVar(&mode, "g", "unspecified",
		"Argument for the granularity of the data required.\nOptions: intraday, daily, weekly, monthly")
	flag.StringVar(&outputFName, "o", "unspecified",
		"Name of the desired output JSON file.")

	flag.Parse()
	sym = strings.ToUpper(sym)
	mode = strings.ToLower(mode)
	validModes = []string{"intraday", "daily", "weekly", "monthly"}

	if outputFName == "unspecified" {
		outputFName = sym + ".json"
	}

	sr := rand.NewSource(time.Now().UnixNano())
	rd = *rand.New(sr)
}

type Response struct {
	MetaData   map[string]string `json:"Meta Data"`
	TimeSeries TS                `json:"Time Series"`
}

type TS map[string]Day

type Day struct {
	Open   json.Number `json:"open"`
	High   json.Number `json:"high"`
	Low    json.Number `json:"low"`
	Close  json.Number `json:"close"`
	Volume json.Number `json:"volume"`
}

func main() {
	if !isIn(validModes, mode) {
		fmt.Println("Invalid mode")
		os.Exit(1)
	}

	url := "https://www.alphavantage.co/query?function=TIME_SERIES_"
	switch mode {
	case "intraday":
		url += "INTRADAY&interval=1min"
	default:
		url += strings.ToUpper(mode)
	}
	url += fmt.Sprintf("&outputsize=full&symbol=%v&apikey=%v", sym, randStr(6))

	var rsp Response
	httpRspRaw, _ := http.Get(url)
	httpRsp, _ := ioutil.ReadAll(httpRspRaw.Body)

	if mode == "intraday" {
		httpRsp = []byte(strings.ReplaceAll(string(httpRsp), " (1min)", ""))
	}
	switch mode {
	case "intraday":
		httpRsp = replaceInBytes(httpRsp, " (1min)", "")
	case "daily":
		httpRsp = replaceInBytes(httpRsp, " (Daily)", "")
	case "weekly":
		httpRsp = replaceInBytes(httpRsp, "Weekly ", "")
	case "monthly":
		httpRsp = replaceInBytes(httpRsp, "Monthly ", "")
	}
	for _, v := range []string{"1. ", "2. ", "3. ", "4. ", "5. "} {
		httpRsp = replaceInBytes(httpRsp, v, "")
	}

	_ = json.Unmarshal(httpRsp, &rsp)

	saveJSON(rsp.TimeSeries)
}

func saveJSON(rsp TS) {
	f, _ := os.Create(outputFName)
	bytes, _ := json.MarshalIndent(rsp, "", "    ")
	_, _ = f.Write(bytes)
	f.Close()
}

func randStr(length int) string {
	str := ""

	for i := 0; i < length; i++ {
		str += string(randStrChars[rd.Intn(len(randStrChars))])
	}

	return str
}

func isIn(list []string, element string) bool {
	for _, v := range list {
		if v == element {
			return true
		}
	}
	return false
}

func replaceInBytes(s []byte, old string, new string) []byte {
	return []byte(strings.ReplaceAll(string(s), old, new))
}
