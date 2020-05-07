# -*- coding: utf-8 -*-
import scrapy as sr


class AllQuotesWithAuthorDetailsSpider(sr.Spider):
    name = 'all_quotes_with_author_details'
    allowed_domains = ['toscrape.com']
    start_urls = ['http://quotes.toscrape.com/']

    def parse(self, response):
        for quote_block in response.css("div.quote"):
            author_pg = quote_block.css("span > a::attr(href)").extract_first()
            author_pg = response.urljoin(author_pg)

            yield{
                "author": next(self.author_details(author_pg)),
                "quote": quote_block.css("span.text::text").extract_first().strip()[1:-1],
                "tags": [tag.strip() for tag in quote_block.css("a.tag::text").extract()]
            }

        nxt_pg_url = response.css("li.next > a::attr(href)").extract_first()

        if nxt_pg_url:
            nxt_pg_url = response.urljoin(nxt_pg_url)
            yield sr.Request(url=nxt_pg_url, callback=self.parse)

    def parse_author(self, response):
        yield {
            "name": response.css("h3.author-title::text").extract_first().strip(),
            "dob": response.css("span.author-born-date::text").extract_first().strip(),
            "dob-location": response.css("span.author-born-location::text").extract_first().strip()[3:],
            "description": response.css("div.author-description::text").extract_first().strip()
        }

    def author_details(self, pg_url):
        yield sr.Request(url=pg_url, callback=self.parse_author)
