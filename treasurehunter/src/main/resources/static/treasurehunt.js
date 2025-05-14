let clickCounter = 0;
let messageElement = null;
let userId = 0;
let userName = null;
let lives = 0;
let startGame = null;
let lastSaved = null;
let isWin = false;


window.onload = function(){
	
	let cellElements = document.getElementsByClassName("cell");
	
	userId = parseInt(document.getElementById("uid").value);
	userName = document.getElementById("name").value;
	lives = parseInt(document.getElementById("live").value);
	
	startGame = new Date().toISOString();
	
	if(lives === 0){
		let restartLives = confirm("You are out of lives. Would you like to restart?");
		if(restartLives){
			
			lives = 3;
			characterPlacement();
			for(let index=0; index < cellElements.length; index++){
				let currentCellElement = cellElements[index];
				currentCellElement.onclick = function(){
					clickCell(currentCellElement);
				}
			}
		}

	}else{
		characterPlacement();
		for(let index=0; index < cellElements.length; index++){
			let currentCellElement = cellElements[index];
			currentCellElement.onclick = function(){
				clickCell(currentCellElement);
			}
		}
		
		
	}
	startAutoSave();
	
}

function randomIndices(count, numberOfCells){
	let indices = [];
	
	while(indices.length < count){
		let randomNumber = Math.floor(Math.random() * numberOfCells);
		if(!indices.includes(randomNumber)){
			indices.push(randomNumber);
		}
	}
	
	console.log(indices);
	
	
	return indices;
	
	
}

function characterPlacement(){
	
	let cellElements = document.getElementsByClassName("cell");
	let totalCells = cellElements.length;
	
	let imagesIndex = randomIndices(3, totalCells);
	
	for(let index = 0; index < totalCells; index++){
		let currentCell = cellElements[index];
		
		if((imagesIndex[0] === index) || imagesIndex[2] === index){
			
			currentCell.setAttribute("dataType", "pirate");
		}
		else if(imagesIndex[1] === index){
			currentCell.setAttribute("dataType", "treasure");
		}
		else{
			currentCell.setAttribute("dataType", "empty");
		}
	}
}


async function clickCell(cell){
	
	let isWin = null;
	let messageElement = document.getElementById("message");
	let cellType = cell.getAttribute("dataType");
	
	clickCounter++;
	messageElement.innerHTML = clickCounter + " step(s)";
	
	if(cellType === "pirate"){
		cell.classList.add("signPirate")
		isWin = false;
		lives--;
			
		await saveGame(userId, startGame, clickCounter, isWin, lastSaved);
		window.location.href =  `/treasurehunt/uid/${userId}/result?clickCounter=${clickCounter}&result=${isWin}&lives=${lives}`;
		
	}
	else if(cellType === "treasure"){
		cell.classList.add("signTreasure");
		isWin = true;
		
		await saveGame(userId, startGame, clickCounter, isWin, lastSaved);
		window.location.href = `/treasurehunt/uid/${userId}/result?clickCounter=${clickCounter}&result=${isWin}&lives=${lives}`;
	}
	else{
		cell.style.backgroundColor = "#A9A9A9";
	}
	
	
	
}

async function saveGame(userId, startGame, clickCounter, isWin){
	
	lastSaved = new Date().toISOString();
	
	await fetch(`http://localhost:8081/treasurehunt/save?userId=${userId}&startGame=${startGame}&steps=${clickCounter}&result=${isWin}&lastSaved=${lastSaved}`, {
	        method: 'POST'
	})
	.then(response => response.text())
	.then(message => {
		showAutoSaveMessage(message);
	})
	.catch(error => console.error('Error during autosave', error));

}

function startAutoSave(){
	setInterval(() => {
		saveGame(userId, startGame, clickCounter, isWin, lastSaved);
	}, 10000);
}

function showAutoSaveMessage(message){
	
	let saveMessageElement = document.getElementById("saveMessage");
	saveMessageElement.textContent = "Autosave successful!"
	
	saveMessageElement.style.display = "block";
	
	setTimeout(() => {
		saveMessageElement.style.display = "none";
	}, 2000);
}

