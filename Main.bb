;MATH FIGHTERS

;Programmer : ProfRedKey, owner of The Red Key's Productions

;MAIN CATEGORY
;START BASICS RESOLUTIONS

;(The program wont works if the ReadFile("options.ini") is in include_locals)


;[[ Using the code is acceptable with appropriate credit ! ]]

;[Graphics, music... parameters are in options.ini, and options.ini functions are in include_locals]

file = ReadFile("options.ini")

screengraphix =    GetINIInt("options.ini","options","graphix")
screengraphiy =    GetINIInt("options.ini","options","graphiy")
bits =    GetINIInt("options.ini","options","graphiz")
fullscreen = GetINIInt("options.ini","options","fullscreen")
playintro = GetINIInt("options.ini","options","playintro")

volume = GetINIInt("options.ini","audio","volume")


Set_GFXMode()
PlayIntro()


If fullscreen Then
	Graphics (screengraphix,screengraphiy,bits)
	DebugLog "FULLSCREEN"
Else
    Graphics (screengraphix,screengraphiy,bits,2)
	DebugLog "NOT FULLSCREEN"
EndIf

SetBuffer BackBuffer()
SeedRnd MilliSecs()

Const title$ =   "Math Fighters v"
Const version$ = "0.2"

AppTitle ""+title$+version$

;Includes :

Include "include_locals.bb"

;EXECUTOR

While Not KeyDown(1)

Main()

Wend 
End

;END BASICS RESOLUTIONS

 ; ** START FUNCTION **

;-----------------------------
;-----------------------------

;-----------------------------
;-----------------------------


Function Main()
Select room

;-----------------------------

Case 0 ;MENU
Cls

Print
Print
Print "Hello, welcome to the lobby. You can select by typing a number"
Print
Print "If you type something else or did a mistake example : << !conTaCt >>."
Print "It will just execute nothing."
Print
Print "Have fun!"
Print
Print "!contact = List of contacts (only 10 seconds visibility)"
Print
Print "The Lobby."
Print 
Print "1 = Math Category"
Print "2 = Status"
Print "3 = Settings"
Print "4 = Updates"
Print
Print "5 = Exit (Are you sure to exit?)"
Print
Print "Tutorial coming soon."
Print
Print "2021-2022 The RedKey's Productions"
Print
Print

inpt = Input("Type a number for select : ")

Select inpt
Case "!contact"

Print
Print "List of contacts :"
Print
Print "QllesCord#3578 (Discord)":Delay 10000
End Select

Select inpt

Case "1"
room = 1

Case "2"
room = 2

Case "3"
room = 6

Case "4"
room = 5

Case "5"
Print "3":Delay 1000
Print "2":Delay 1000
Print "1":Delay 1000

Select Rand(4)
Case 1
RuntimeError("noice u just leve the geme.. ;-;")
End
Case 2
RuntimeError("It's not about whether you die or not, it's about when you die.")
End
Case 3
RuntimeError("Have a nice day!")
End
Case 4
RuntimeError("Welcome to the 0010101100")	
End 
End Select 


End Select

;---------------------------

Case 1 ;MATH CATEGORY
Cls
Print "Hello there, welcome to the Math Category!"
Print
Print "1 = Math - 1"
Print "2 = Math - 2 (Level 5+ required)"
Print "3 = Math - 3 (Level 8+ required)"
Print "4 = Math - 4 (Level 12+ required)"
Print 
Print "5 = BOSS FIGHT (UNDER CONSTRUCTION)"
Print
Print
Print "0 = Back"
inpt = Input("")
Select inpt
Case "0"
room = 0

Case "1"
room = 10

Case "2"
If level >= 5 Then room = 11 Else Print "Level 5+ required.":Delay 500

Case "3"
If level >= 8 Then room = 12 Else Print "Level 8+ required.":Delay 500

Case "4"
If level >= 12 Then room = 13 Else Print "Level 12+ required.":Delay 500

Case "5"
If level >= 9999999999999999 Then room = 14 Else Print "Level 15+ required.":Delay 500


End Select

;-------------------------------

Case 2 ;STATUS
Cls

Print "XP: "+xp
Print "Level: "+level
Print "Strength: "+strength
Print "XP to next level: "+xp+"/"+tonextlevel
Print
Print "1 = LEVEL UP! (Require xp = tonextlevel) : "
Print
Print "0 = Lobby"
inpt = Input("")
Select inpt

Case "0"
room = 0

Case "1"
If xp >= tonextlevel Then

morepoints = Rand(30,60)

level = level + 1
tonextlevel = tonextlevel + morepoints
Print "Congratulations! You're now level "+level:Delay 2000
Else
Print "You don't have enough xp for rank up.":Delay 2000

EndIf

End Select

;------------------------------

Case 10 ;MATH LEVEL 1
Cls

x = Rand(1,10)
y = Rand(1,10)
d = Rand(1,4)

If d = 2 And x-y < 0 And d = 4 Then y = 1

If Float(x) Mod Float(y) > 0 And d = 4 Then y = 1

Select d
Case 1 ;ADDITIONING
Print "Please resolve this problem. Additioning"
Print
Print "What is... "+x+"+"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x+y Then
Print "Correct!":Delay 500
xp = xp + strength+2

ElseIf inpt <> "exit" And Int(inpt) <> x+y
Print "Incorrect! The answer is "+(x+y):Delay 1000
Else
room = 0
EndIf


Case 2 ;SUBSTRACTING
Print "Please resolve this problem. Subtracting"
Print
Print "What is... "+x+"-"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x-y Then
Print "Correct!":Delay 500

xp = xp + strength+2

ElseIf inpt <> "exit" And Int(inpt) <> x-y
Print "Incorrect! The answer is "+(x-y):Delay 1000
Else
room = 0
EndIf

End Select

;--------------------------------------------------

Case 11 ;MATH LEVEL 2
Cls

x = Rand(3,10)
y = Rand(3,10)
d = Rand(1,4)

If d = 2 And x-y < 0 And d = 4 Then y = 1

If Float(x) Mod Float(y) > 0 And d = 4 Then y = 1

Select d
Case 1 ;ADDITIONING
Print "Please resolve this problem. Additioning"
Print
Print "What is... "+x+"+"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x+y Then
Print "Correct!":Delay 500
xp = xp + strength+2

ElseIf inpt <> "exit" And Int(inpt) <> x+y
Print "Incorrect! The answer is "+(x+y):Delay 1000
Else
room = 0
EndIf


Case 2 ;SUBSTRACTING
Print "Please resolve this problem. Subtracting"
Print
Print "What is... "+x+"-"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x-y Then
Print "Correct!":Delay 500

xp = xp + strength+2

ElseIf inpt <> "exit" And Int(inpt) <> x-y
Print "Incorrect! The answer is "+(x-y):Delay 1000
Else
room = 0
EndIf

Case 3 ;MULTIPLICATING
Print "Please resolve this problem. Multiplying"
Print "[MORE XP THAN HABITUAL]"
Print
Print "What is... "+x+"x"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x*y Then
Print "Correct!":Delay 500

xp = xp + strength+3

ElseIf inpt <> "exit" And Int(inpt) <> x*y
Print "Incorrect! The answer is "+(x*y):Delay 1000
Else
room = 0
EndIf

End Select


;--------------------------------

Case 12 ;MAH LEVEL 3
Cls

x = Rand(6,12)
y = Rand(4,12)
d = Rand(1,4)

If d = 2 And x-y < 0 And d = 4 Then y = 1

If Float(x) Mod Float(y) > 0 And d = 4 Then y = 1

Select d
Case 1 ;ADDITIONING
Print "Please resolve this problem. Additioning"
Print
Print "What is... "+x+"+"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x+y Then
Print "Correct!":Delay 500
xp = xp + strength+2

ElseIf inpt <> "exit" And Int(inpt) <> x+y
Print "Incorrect! The answer is "+(x+y):Delay 1000
Else
room = 0
EndIf


Case 2 ;SUBSTRACTING
Print "Please resolve this problem. Subtracting"
Print
Print "What is... "+x+"-"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x-y Then
Print "Correct!":Delay 500

xp = xp + strength+2

ElseIf inpt <> "exit" And Int(inpt) <> x-y
Print "Incorrect! The answer is "+(x-y):Delay 1000
Else
room = 0
EndIf

Case 3 ;MULTIPLICATING
Print "Please resolve this problem. Multiplying"
Print "[MORE XP THAN HABITUAL]"
Print
Print "What is... "+x+"x"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x*y Then
Print "Correct!":Delay 500

xp = xp + strength+3

ElseIf inpt <> "exit" And Int(inpt) <> x*y
Print "Incorrect! The answer is "+(x*y):Delay 1000
Else
room = 0
EndIf

End Select

;--------------------------------

Case 13 ;MATH LEVEL 4
Cls

x = Rand(6,10)
y = Rand(4,10)
d = Rand(1,4)

If d = 2 And x-y < 0 And d = 4 Then y = 1

If Float(x) Mod Float(y) > 0 And d = 4 Then y = 1

Select d
Case 1 ;ADDITIONING
Print "Please resolve this problem. Additioning"
Print
Print "What is... "+x+"+"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x+y Then
Print "Correct!":Delay 500
xp = xp + strength+2

ElseIf inpt <> "exit" And Int(inpt) <> x+y
Print "Incorrect! The answer is "+(x+y):Delay 1000
Else
room = 0
EndIf


Case 2 ;SUBSTRACTING
Print "Please resolve this problem. Subtracting"
Print
Print "What is... "+x+"-"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x-y Then
Print "Correct!":Delay 500

xp = xp + strength+2

ElseIf inpt <> "exit" And Int(inpt) <> x-y
Print "Incorrect! The answer is "+(x-y):Delay 1000
Else
room = 0
EndIf

Case 3 ;MULTIPLICATING
Print "Please resolve this problem. Multiplying"
Print "[MORE XP THAN HABITUAL]"
Print 
Print "What is... "+x+"x"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x*y Then
Print "Correct!":Delay 500

xp = xp + strength+3

ElseIf inpt <> "exit" And Int(inpt) <> x*y
Print "Incorrect! The answer is "+(x*y):Delay 1000
Else
room = 0
EndIf

Case 4 ;DIVIDING
Print "Please resolve this problem. Dividing"
Print "[MORE XP THAN HABITUAL]"
Print 
Print "What is... "+x+"÷"+y+"?"
Print "(exit = exit)"
inpt = Input("")

If Int(inpt) = x/y Then
Print "Correct!":Delay 500

xp = xp + strength+4

ElseIf inpt <> "exit" And Int(inpt) <> x/y
Print "Incorrect! The answer is "+(x/y):Delay 1000
Else
room = 0
EndIf

End Select

;--------------------------------

Case 14 ;BOSS FIGHT [COMING SOOOOOOOOON]
Cls

Print "Boss fight!"

ChannelVolume Music,0

;--------------------------------

Case 5 ;UPDAAAAATES
Cls
Print "Updates"
Print
Print "V0.2 :"
Print "(Last edit : 09/04/2022)"
Print
Print "- Added Intro of Red Key's Productions"
Print 
Print "- BOSS FIGHT coming soon"
Print
Print "- Added some parameters"
Print
Print "- Fixed load data"
Print
Print 
Print "0 = Back (Lobby)"
inpt = Input("")
Select inpt
Case "0"
room = 0

End Select


Case 6 ;SETTINGS
Cls
Print "Settings 1/2"
Print
Print "1 = Settings 2/2"
Print "2 = Music volume"
Print "3 = Resolution of Graphics"
Print "4 = Save/Load"
Print
Print
Print "0 = Back (Lobby)"
inpt = Input("")
Select inpt
Case "0"
room = 0

Case "1"
If level >= 1 Then room = 99 Else Print "Level 5+ required.":Delay 500

Case "2"
If level >= 1 Then room = 100 Else Print "Level 5+ required.":Delay 500

Case "3"
If level >= 1 Then room = 101 Else Print "Level 5+ required.":Delay 500

Case "4"
room = 103

End Select

Case 99
Cls
Print "No settings for now. :-)"
Print
Print "0 = Back (Settings 1/2)"
inpt = Input("")
Select inpt
Case "0"
room = 6

End Select

Case 100
Cls
Print "Music Volume"
Print
Print "0 = Back (Settings 1/2)"
Print
Print "1 = Change volume"
inpt = Input("")
Select inpt

Case "0"
room = 6

Case "1"
Print 
Print "0/1 (Volume) :"
inpt1 = Input("")

ChannelVolume Music, inpt1

End Select


;---------------------------------------------------------------------------------------------------

;THIS IS JUST BUG FIX OF NUMBERS, SORRY

Case 103
Cls
Print "Save or load you progress"
Print
Print "1 = Save (All saves are saved in << Saves >> folder)"
Print "2 = Load (THIS WILL WORKS ONLY AFTER YOU SAVED YOUR STATS)"
Print
Print "0 = Back (Settings 1/2)"
inpt = Input("")
Select inpt

Case "0"
room = 6

Case "1"
Print "Do you want to save your progress?"
Print
inpt = Input("yes/no: ")

If inpt = "yes"
fileout = WriteFile("Saves\save.dat")

WriteInt(fileout,level)
WriteInt(fileout,strength)
WriteInt(fileout,xp)
WriteInt(fileout,tonextlevel)
CloseFile(fileout)
Print "Your progress are saved.":Delay 1000

EndIf

Case "2"
Print "Do you want to load your progress?"
Print
inpt = Input("yes/no: ")

If inpt = "yes"
filein = ReadFile("Saves\save.dat")
;Print "Sorry, the file may be corrupted or deleted." ;!!!!!! ONLY ENABLE THIS IF THE LOAD IS BROKEN

level=ReadInt(filein)
strength=ReadInt(filein)
xp=ReadInt(filein)
tonextlevel=ReadInt(filein)
	
CloseFile(filein)

Print "Your progress are loaded.":Delay 1000

EndIf 

End Select

;-----------------------------------------------------------------------------------------------------

Case 101
Cls
Print "Resolution :"
Print
Print "0 = Back (Settings 1/2)"
;Print "1 = Graphics Minimum (Main) = 800x600"
;Print "2 = Graphics Medium = 1250x840"
;Print "3 = Graphics Maximum WARNING, BIG SCREEN ONLY = 1999x1000"
Print 
Print "1 = Resolution Graphics (X, Y, Bits, Fullscreen)"
Print
Print "2 = Current Resolution Graphics"
Print 
inpt = Input("")
Select inpt
Case "0"
room = 6

;Case "1"
;Graphics 800,600,16

;Case "2"
;Graphics 1250,840,16

;Case "3"
;Graphics 1999,1000,16

Case "1"
Print
Print "*(800x600 // 640x480 is advised)"
Print
Print "*( I recommend you to use the graphics next to the message up"
Print "otherwise a runtime error can pop up if the program didn't agree )"
Print 
Print "Common runtime error's message : << Unable to set graphics >>"
Print
inpt = Input("X Resolution : ")
inpt1 = Input("Y Resolution : ")
inpt2 = Input("Color depth in bits (0, 16, 24 or 32) : ")
inpt3 = Input("Fullscreen? (1 = true // 2 = false // 3 = everything) : ")

Set_GFXMode()

Graphics(inpt, inpt1, inpt2, inpt3)

;OOOOOOOOOOOOOOOOOOF

Case "2"
Print
Print "The current graphics resolution are :"
Print
Print "X Resolution          : "+ GraphicsWidth()
Print "Y Resolution          : "+ GraphicsHeight()
Print "Color depth (in bits) : "+ GraphicsDepth()
Print "Screen Buffer         : "+ GraphicsBuffer()
Delay(4000)

;-----------------------

End Select
End Select

Locate 0,0
End Function

;-----------------------------
;-----------------------------

;-----------------------------
;-----------------------------

;** End Function **


Function PlayIntro()

	Graphics (800,600,32,2)
	SetBuffer BackBuffer()

	;If GetINIInt("options.ini","options","playintro")=0 Then Return 
	
		;RuntimeError("ENABLED")
	
	HidePointer()
   
    Local ScaledGraphicHeight%
    Local Ratio# = Float(RealGraphicWidth)/Float(RealGraphicHeight)
    If Ratio>1.76 And Ratio<1.78
        ScaledGraphicHeight = RealGraphicHeight
        DebugLog "Not Scaled"
    Else
        ScaledGraphicHeight% = Float(RealGraphicWidth)/(16.0/9.0)
        DebugLog "Scaled: "+ScaledGraphicHeight
    EndIf
    
    Local moviefile$ = "GFX\menu\teste"
        BlitzMovie_Open(moviefile$+".avi") ;Get movie size
	Local moview = BlitzMovie_GetWidth() ;BlitzMovie_GetWidth() / 2
	Local movieh = BlitzMovie_GetHeight() ;BlitzMovie_GetHeight() / 2
    BlitzMovie_Close()	
	
	Local image = CreateImage(moview, movieh)
	Local SplashScreenVideo = BlitzMovie_OpenDecodeToImage(moviefile$+".avi", image, False)
	;Local SplashScreenVideo = BlitzMovie_OpenD3D(moviefile$+".avi", SystemProperty("Direct3DDevice7"), SystemProperty("DirectDraw7"))
	SplashScreenVideo = BlitzMovie_Play()
	
	Delay(15000)
	
        BlitzMovie_Stop()
        BlitzMovie_Close()
;        
        Cls
        Flip
;    
  ShowPointer()
;
End Function

Function Set_GFXMode()
    Graphics (800,600,32,2)

	SetBuffer BackBuffer()
	Text GraphicsWidth()/2,GraphicsHeight()/2,"Initialising Graphics...",True,True
	Delay(1000)
	Flip
	
End Function