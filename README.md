# Ping-Pong
Pong


I. Hitboxes And Trajectories

  1. Ball (object)
  2. Boundary walls (parameter)
  3. Goals (parameter)
  4. Paddles (object)
  
    a. Multiple hitboxes on paddle to change change angle
  
II. Scoring

  1. Goals
  
    a. Score increment
    
III. Events 

  1. Keystroke detection
  
    a. Paddle movement
    b. Pause
  2. Ball movement
  3. Menu Options
  
IV. Graphics
  
  1. Rectangles
  
    a. Ball
    b Paddles
  2. Score display
  
Game
    Ball speed
    Bounds[]
    Bounds checkBounds()
    Paddle checkWin()
    
    Ball(int frameHeight, int frameWidth, double mag)
        double speed
        Rectangle
        double [] vector
        double [] reflect()
        void setVector()
    Bounds(int frameHeight, int frameWidth)
        int[] reflector
        Rectangle
    Paddle(int frameHeight, int frameWidth) extends Bounds
        void move
