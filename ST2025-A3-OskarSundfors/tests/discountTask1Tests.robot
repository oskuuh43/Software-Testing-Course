*** Settings ***
Library  ../resources/DiscountLibrary.py

*** Test Cases ***
T1
    Get Discount    ${100}    ${True}
    Result Should Be    ${1}

T2
    Get Discount    ${10}    ${False}
    Result Should Be    ${0}

T3
    Get Discount    ${0}    ${True}
    Result Should Be    ${-1}

T4
    Get Discount    ${100000}    ${False}
    Result Should Be    ${-1}