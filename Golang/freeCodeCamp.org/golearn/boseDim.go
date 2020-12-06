package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	response, _ := http.Get("http://192.168.0.11:8090/volume")
	body, _ := ioutil.ReadAll(response.Body)
	stringBod := string(body)
	
}

func getPostXML(volume uint8) string {
	return fmt.Sprintf("<volume>%v</volume>", volume)
}
