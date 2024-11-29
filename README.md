# MockWrappedBean demo

What is this? [Read the explanation here](https://filip-prochazka.com/blog/mockbean-is-an-anti-pattern).

This project is not meant as a library, but instead as an inspiration/demo.

## `example-problem-demonstration`

This module demonstrates how Spring starts multiple context. This is very quick in a small project, but becomes a problem as the project grows.

## `example-fix-custom-mockwrappedbean`

This was my personal take on how to solve problem, only to later find out that there is a better way.

## `example-fix-spybean`

This is currently the easiest and most reliable way to enable mocking of services without having many Spring contexts started.
