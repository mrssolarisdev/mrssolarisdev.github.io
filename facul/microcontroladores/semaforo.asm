; A versão anterior não estava 100% correta.
; Agora o amarelo só acende na transição entre verde e vermelho. Integrantes:
; Fábio Duarte Freitas
; Marcela Braga Bahia 
ORG 0000h
	JMP MAIN

ORG 0013h
	JNB P0.4,TRATABOTAO
	CLR IE1;desliga int1
RETI
;aqui precisa de reti, 
;se a subrotina acima não é executada
;o reti da subrotina não atingida
;não encerra a interrupção
             
ORG 000Bh
    ACALL TOGGLE
;decide qual led será ligado

ORG 0033h	
TRATABOTAO:
	MOV P1,#0B6h;vermelho
	CLR 20h.6;desliga flag amarelo
	SETB 20h.7;liga flag vermelho
	MOV TH0,#0D8h;realimenta 10ms
	MOV TL0,#0EFh
	CLR IE1;desliga flag int1
RETI

TOGGLE:
;SE BIT 20H.6 = 0 amarelo desligado, liga amarelo
	JNB 20h.6,YELLOW
;SE BIT 20H.7 = 0 verde desligado, liga vermelho
 	JNB 20h.7,RED
;SE BIT 20H.7 = 1 vermelho desligado, liga verde
 	JB 20h.7, GREEN
;as subrotinas retornam para o programa
;principal e não para a interrupção, 
;já que o ultimo endereço em sp foi o 
;de acall toggle, isso é proposital.
RETI
             
YELLOW:
 	MOV P1,#6Dh
	MOV TH0,#0ECh;realimentando 5ms
 	MOV TL0,#77h
 	SETB 20h.6;flag amarelo ligado
RETI
       
RED:
	CALL DPCOUNT
 	SETB 20h.7;BIT 1 = vermelho ligado
	MOV P1, #0B6h
	SETB 20h.6;liga flag amarelo
	;fazendo isso, no fim da interrupção de tempo do vermelho
	;o amarelo não será aceso, indo direto para o verde.
	;(se os carros já estão parados,não precisa de atenção)
RETI
      
GREEN:
	CALL DPCOUNT
 	CLR 20h.7;BIT 0 = verde ligado
 	MOV P1,#0DBh
	CLR 20h.6;zera flag amarelo
	;fazendo isso, no fim da interrupção de tempo do verde
	;ao passar pela rotina de tratamento o amarelo será ligado
	;(representa o sinal de atenção para os carros pararem)
RETI
     
DPCOUNT:
	MOV TH0,#0D8h;realimentando 10ms 
 	MOV TL0,#0EFh
RET    

  
MAIN:
 MOV PSW,#00h     ;zera psw
 MOV SP,#60h      ;stack pointer em 60H
 MOV IE,#10000110b;all,timer 0 e int1
 MOV IP,#00000100b ;prioriza teclado
   
 ;Temporizadores, interrupções
 MOV TCON,#00010000b ;hab timer 0, int1 por nv
 MOV TMOD,#01h       ;modo 01 - timer de 16bits

;10ms contando
 MOV TH0,#0D8h
 MOV TL0,#0EFh
 MOV P1,#0DBh ;verde ligado inicialmente   	
 ;botao
 CLR P0.0 ;liga linha 0 do teclado
 ;indicador do sinal ligado atualm.
 ;são usados somente os dois primeiros 
 ;bits do endereço como flags
 ;20h.7 -> 1=vermelho 0=verde
 ;20h.6 -> 1=amarelo ligado 0=desligado
 MOV 20h,#00h ;reseta a zona de mem. 
JMP $
       
END
