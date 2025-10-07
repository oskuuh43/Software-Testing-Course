*** Settings ***
Library    ../resources/AlarmLibrary.py

*** Variables ***

*** Test Cases ***
T1
    [Documentation]    path: [1,1,2,2,1]
    Reset
    Disarm
    Result Should Be    ${2}
    Close Doors
    Result Should Be    ${0}
    Disarm
    Result Should Be    ${2}
    Open Doors
    Result Should Be    ${0}

T2
    [Documentation]    path: [1,4,3,2,3]
    Reset
    Arm
    Result Should Be    ${0}
    Close Doors
    Result Should Be    ${1}
    Disarm
    Result Should Be    ${2}
    Arm
    Result Should Be    ${1}

T3
    [Documentation]    path: [1,4,3,3,4]
    Reset
    Arm
    Result Should Be    ${0}
    Close Doors
    Result Should Be    ${1}
    Arm
    Result Should Be    ${1}
    Open Doors
    Result Should Be    ${27}

T4
    [Documentation]    path: [1,4,4,1]
    Reset
    Arm
    Result Should Be    ${0}
    Arm
    Result Should Be    ${0}
    Disarm
    Result Should Be    ${2}
