;Math Fighters

;LIBRARY CATEGORY

;Others than Local, Global, etc...

;--------------------------------------------------------------------------
;--------------------------------------------------------------------------

;READFILE


;GLOBALS/LOCALS

;PLAYER's DATA

Global inpt$ = ""               ;-This is for put something. c:
Global room$ = 0                ;-It's not easy to use rooms, because there are much rooms. Room 0 = Lobby.
Global strength% = 1            ;-This is for know how are you strong in this game.
Global level% = 1               ;-Level 1 for beginning ( start() )
Global multiplier# = 1.6180339   ;-Just for math training
Global tonextlevel% = 50        ;-This is for level up.
Global xp% = 0            ;-xp is important for make you rank up.

;GLOBALS

Global bool1 = False

Global Music = PlayMusic("SFX\MainMusic.wav")
ChannelVolume Music,volume

;--------------------------------------------------------------------------
;--------------------------------------------------------------------------

;FUNCTIONS

Function GetINIInt$(file$, section$, parameter$)
	Local Stri$= Trim(GetINIString(file$, section$, parameter$))
	If Lower(Stri) = "true" Then
		Return 1
	ElseIf Lower(Stri) = "false"
		Return 0
	Else
		Return Int(Stri)
	EndIf
End Function

Function GetINIString$(file$, section$, parameter$)
	Local TemporaryString$ = ""
	Local f = ReadFile(file)
	
	While Not Eof(f)
		If Lower(ReadLine(f)) = "[" + Lower(section) + "]" Then
			Repeat
				TemporaryString = ReadLine(f)
			 	If Lower(Trim(Left(TemporaryString, max(Instr(TemporaryString, "=") - 1, 0)))) = Lower(parameter) Then
					CloseFile f
					Return Trim( Right(TemporaryString,Len(TemporaryString)-Instr(TemporaryString,"=")) )
				EndIf
			Until Left(TemporaryString, 1) = "[" Or Eof(f)
			CloseFile f
			Return ""
		EndIf
	Wend
	
	CloseFile f
End Function

Function max#(n1#, n2#)
	If n1 > n2 Then Return n1 Else Return n2
End Function