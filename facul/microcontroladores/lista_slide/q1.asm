ORG 0000h

MOV 5Fh, #30h
MOV 7Ch, #39h
MOV A, 5Fh
MOV B, 7Ch
MUL AB
SETB RS1
SETB RS0
MOV R5, B
CLR RS0
MOV R7, A

end