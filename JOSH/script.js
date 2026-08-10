let red = document.getElementById("red");
let green = document.getElementById("green");
let yellow = document.getElementById("yellow");
let blue = document.getElementById("blue");

let gameSequence = [];
let playerSequence = [];

let started = false;

function startgame(){
    if (started) return true;
    started = true;
    gameSequence = [];
    playerSequence = [];

    nextLevel();
}

function nextLevel(){
    playerSequence = []
    let randomColor = Math.floor(Math.random() * 4)+1;
    gameSequence.push(randomColor);
    showSequence();
}

function showSequence(){
    gameSequence.forEach(color,index)=>{
        setTimeout(()=>{
            flash(color);
        },(index+1)*800);
    });
}

function flash(color){
    let element;
    if(color === 1) element = red;
    if(color === 2) element = green;
    if(color === 3) element = blue;
    if(color === 4) element = yellow;

    element.style.opacity ="0.4";
    setTimeout(()=>{
        element.style.opacity = "1";
    },400);
}

function playerMove(color){
    playerSequence.push(color);
    let currentIndex = playerSequence.length-1;
    if(playerSequence[currentIndex] !== gameSequence[currentIndex]){
        alert(
            "Game Over ! Score: "+(gameSequence.length -1)
            );
        started=false;
        gameSequence=[];
        playerSequence=[];
        
        return;
    }
    if(playerSequence.length === gameSequence.length){
        setTimeout(()=>{
            nextLevel();
        },1000);
    }
}

function resetgame(){

    started = false;

    gameSequence = [];
    playerSequence = [];

    red.style.opacity = "1";
    green.style.opacity = "1";
    blue.style.opacity = "1";
    yellow.style.opacity = "1";

    alert("Game Reset");
}

        
