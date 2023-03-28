import random as rnd
import pyautogui
a = 0

tim

# Get the size of the primary display
screenWidth, screenHeight = pyautogui.size()
oke = (round(rnd.random()*screenWidth))
eko = (round(rnd.random()*screenHeight))
print(eko)
print(oke)

# Move the mouse to the center of the screen
pyautogui.moveTo(oke, eko)
