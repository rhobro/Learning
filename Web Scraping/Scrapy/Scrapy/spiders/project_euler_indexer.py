# -*- coding: utf-8 -*-
import scrapy as sr


class ProjectEulerIndexerSpider(sr.Spider):
    name = "project_euler_indexer"
    allowed_domains = ["projecteuler.net"]
    start_urls = ["https://projecteuler.net/archives"]

    def parse(self, response):
        page_urls = response.css("div.pagination > a::attr(href)").extract()
        self.log(page_urls)
        page_urls = page_urls[:len(page_urls) // 2]
        page_urls = [response.urljoin(page_url) for page_url in page_urls]

        for page_url in page_urls:
            yield sr.Request(page_url, self.parse_puzzle_list)

    def parse_puzzle_list(self, response):
        puzzle_urls = response.css("td > a::attr(href)").extract()
        puzzle_urls = [response.urljoin(puzzle_url) for puzzle_url in puzzle_urls]

        for puzzle_url in puzzle_urls:
            yield sr.Request(puzzle_url, self.parse_puzzle)

    def parse_puzzle(self, response):
        puzzle_id = response.css("div > h3::text").extract_first()[8:]
        puzzle_name = response.css("div > div > h2::text").extract_first()

        texts = response.css("div.problem_content > p::text").extract()
        full_question = ""

        for text in texts[:-1]:
            full_question += text + "\n"
        full_question += text

        yield {
            "id": puzzle_id,
            "name": puzzle_name,
            "question": full_question
        }
