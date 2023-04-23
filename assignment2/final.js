let games = [];
function createGame() {
    var object = {
        
            // The "origin" rule is the starting point for the grammar and will generate the full set of game rules
            "origin": ["#intro.capitalize#\n\n#objective#\n\n#setup#\n\n#gameplay#"],
          
            // The "intro" rule generates an introductory sentence to set the context for the game rules
            "intro": ["welcome to the world of #game# games", "let's play a game of #game#", "get ready to learn how to play #game#", "are you ready to become a master of #game#?"],
          
            // The "game" rule generates the name of the game
            "game": ["chess", "checkers", "poker", "bridge", "risk", "scrabble", "monopoly", "settlers of catan"],
          
            // The "objective" rule generates the objective of the game
            "objective": ["the objective of the game is to #win_condition#", "to win the game, you must #win_condition#", "the goal of the game is to #win_condition#"],
          
            // The "win_condition" rule generates the win condition for the game
            "win_condition": ["be the first to reach the finish line", "capture all of your opponent's pieces", "score the most points", "be the last player standing"],
          
            // The "setup" rule generates the setup instructions for the game
            "setup": ["to set up the game, #pieces_setup# #board_setup#", "before playing the game, make sure to #pieces_setup# #board_setup#"],
          
            // The "pieces_setup" rule generates the instructions for setting up the game pieces
            "pieces_setup": ["place all the game pieces on the board", "distribute the game pieces among the players", "shuffle the game pieces and place them face down on the board"],
          
            // The "board_setup" rule generates the instructions for setting up the game board
            "board_setup": ["arrange the board according to the instructions", "lay out the board and any accessories", "assemble the board from the pieces provided"],
          
            // The "gameplay" rule generates the instructions for playing the game
            "gameplay": ["on your turn, #turn_action# until your move is complete", "the game proceeds in rounds, with each player taking a turn", "the game continues until #win_condition# is met"],
          
            // The "turn_action" rule generates a single action that a player can take on their turn
            "turn_action": ["roll the dice and move your piece", "draw a card and follow its instructions", "place a game piece on the board", "take a game piece from an opponent"]
    }

    let grammar = tracery.createGrammar(object);

    let apply = grammar.flatten("#origin#");
    games.push(apply);
    show(games);        
    }

function show(games) {
    let output = document.getElementById("games");
    output.innerHTML = "";
    for (let i=games.length-1; i>=0; i--) {
        output.innerHTML += "<p>" + games[i] + "</p>";
    }
}
// Get the element you want to apply the random color to
const element = document.querySelector('#games');

// Generate a random RGB color
const randomColor = `rgb(${Math.floor(Math.random() * 256)}, ${Math.floor(Math.random() * 256)}, ${Math.floor(Math.random() * 256)})`;

// Apply the random color to the background of the element
games.style.backgroundColor = randomColor;
