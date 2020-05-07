# -*- coding: utf-8 -*-
import scrapy as sr


class AllQuotes1PageSpider(sr.Spider):
    name = 'all_quotes'
    allowed_domains = ['toscrape.com']
    start_urls = ['http://quotes.toscrape.com/']

    def parse(self, response):
        for quote in response.css("div.quote"):
            yield {
                "author": quote.css("small.author::text").extract_first(),
                "quote": quote.css("span.text::text").extract_first()[1:-1],
                "tags": quote.css("a.tag::text").extract()
            }

        nxt_pg_url = response.css("li.next > a::attr(href)").extract_first()
        if nxt_pg_url:
            nxt_pg_url = response.urljoin(nxt_pg_url)
            yield sr.Request(url=nxt_pg_url, callback=self.parse)
