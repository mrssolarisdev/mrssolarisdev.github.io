ORG 0000h

SETB RS1
MOV R7, #39h
MOV A, R7
SETB RS0
MOV R5, #30h
MOV B, R5
DIV AB
MOV PSW, #00h
MOV R0, A
SETB RS0
MOV R2, B

end