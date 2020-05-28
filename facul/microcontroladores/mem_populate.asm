ORG 0000h

 MOV R1, #65h;posição inicial
 MOV 25h, #92h;valor aleatorio
 MOV 55h, #02h;contador de itens
 
ADDR1:
		 MOV @R1, 25h
		 INC R1
		 DEC 25h
		 DJNZ 55h, ADDR1 

END