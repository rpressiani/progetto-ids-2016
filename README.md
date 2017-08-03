# Software Engineering 1 Project

The repo contains the code developed for the final examination of the Software Engineering 1 course held at Politecnico di Milano by professor Ghezzi Carlo.

The project consisted in the development of a multi-threading and distributed application based on the table game "Council Of Four". The application is written in Java 8 and the architecture is based on the MVC pattern. The CLI version of the app is available along with a basic GUI implementation.

The project has been developed by @rpressiani, @MatteoPenco and Alessandro Pezzotta.

# How to run the application

- To start the game you need to launch the class "Server" in Server package, then to launch the class "Client" in Client package.

- Default IP address of our server is 127.0.0.1: you need to select this address to connect to the server.

- There is a timeout of 40 seconds for joining a starting match (from 2 to N players) and there is the same timeout for each player to make succesfully a move, or you will be disconnected.

- When playing via GUI, you need to resize the window to see all the buttons.
