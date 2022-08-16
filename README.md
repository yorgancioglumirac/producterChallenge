# producterChallenge
Graphql + Spring project for Producter

-> You should change application.properties file according to your config

-> Example for Mutation and Query:

      mutation{deletePlayer
        (id:5)
      }
      
      
      mutation{addPlayer(player:{name:"Producter",surname:"Urla/İZMİR", position:PowerForward}){ 
        id
        name
        surname
        position
        }
      }
      
      query{getAllPlayers {
        id
        name
        surname
        position
      }}
