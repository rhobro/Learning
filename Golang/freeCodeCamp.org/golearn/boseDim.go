package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
	"strconv"
	"strings"
	"time"
)

func main() {
	ip := os.Args[1]
	dimInterval, _ := time.ParseDuration(os.Args[2])

	response, _ := http.Get(fmt.Sprintf("http://%v:8090/volume", ip))
	body, _ := ioutil.ReadAll(response.Body)
	responseBody := string(body)

	volIdxStart := strings.Index(responseBody, "<targetvolume>") + 14
	volIdxEnd := strings.Index(responseBody, "</targetvolume>")
	volume, _ := strconv.Atoi(responseBody[volIdxStart:volIdxEnd])

	for i := volume; i > 0; i-- {
		time.Sleep(dimInterval)
		_, _ = http.Post(fmt.Sprintf("http://%v:8090/volume", ip),
			"text/xml",
			strings.NewReader(getPostXML(i)))
	}
}

func getPostXML(volume int) string {
	return fmt.Sprintf("<volume>%v</volume>", volume)
}
