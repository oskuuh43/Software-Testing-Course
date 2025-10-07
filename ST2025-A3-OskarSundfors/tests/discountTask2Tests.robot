*** Settings ***
Library  ../resources/DiscountLibrary.py

*** Test Cases ***
T1
    Get Discount    ${0}    ${True}
    Result Should Be    ${-1}

T2
    Get Discount    ${1}    ${True}
    Result Should Be    ${0}

T3
    Get Discount    ${0}    ${False}
    Result Should Be    ${-1}

T4
    Get Discount    ${1}    ${False}
    Result Should Be    ${0}

T5
    Get Discount    ${10000}    ${True}
    Result Should Be    ${1}

T6
    Get Discount    ${10001}    ${True}
    Result Should Be    ${-1}

T7
    Get Discount    ${10000}    ${False}
    Result Should Be    ${1}

T8
    Get Discount    ${10001}    ${False}
    Result Should Be    ${-1}