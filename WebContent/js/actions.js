
// for selecting ideal match, just working FINE
$( function() {
    var Idmstate = true;
    var lookingForSt = false;
    var lookingForMeSt = false;
    $( "#idmatch" ).on( "click", function() {
      if ( Idmstate ) {
        $( "#idmatch" ).animate({
          backgroundColor: "#008000",
          color: "#fff"
        }, 100 ),$( "#lookingFor" ).animate({
            backgroundColor: "#000000",
            color: "#fff"
          }, 100 ),$( "#lookingForMe" ).animate({
              backgroundColor: "#000000",
              color: "#fff"
            }, 100 ), idmatchflag.setAttribute('value', 1),document.body.appendChild(idmatchflag),
            lookingforflag.setAttribute('value',0),document.body.appendChild(lookingforflag)
            lookingforMeflag.setAttribute('value',0),document.body.appendChild(lookingforMeflag),
            console.log(idmatchflag);
      } else {
        $( "#idmatch" ).animate({
          backgroundColor: "#33b5e5",
          
        }, 100 ),$( "#lookingFor" ).animate({
            backgroundColor: "#33b5e5",
            
          }, 100 ),$( "#lookingForMe" ).animate({
              backgroundColor: "#33b5e5",
              
            }, 100 ),idmatchflag.setAttribute('value', 0),document.body.appendChild(idmatchflag),
            lookingforflag.setAttribute('value',0),document.body.appendChild(lookingforflag),
            lookingforMeflag.setAttribute('value',0),document.body.appendChild(lookingforMeflag),
            console.log(idmatchflag);
      }
      Idmstate = !Idmstate;
      
      
    });
  } );

// for selecting whom i am looking for, working fine
$( function() {
    var lookingForSt = false;
    var lookingForMeSt = true;
    $( "#lookingFor" ).on( "click", function() {
        if ( lookingForMeSt && !lookingForSt) {
        	$( "#lookingFor" ).animate({
                backgroundColor: "#008000",
                color: "#000"
              }, 100 ),lookingforflag.setAttribute('value', 1), document.body.appendChild(lookingforflag),
              console.log(lookingforflag);
        } else { 
        	$( "#lookingFor" ).animate({
                backgroundColor: "#33b5e5",
                color: "#FFF"
              }, 100 ),lookingforflag.setAttribute('value', 0),document.body.appendChild(lookingforflag),
              console.log(lookingforflag);
        }
        lookingForSt = !lookingForSt;
    	lookingForMeSt = !lookingForMeSt;
      }); 
});


//for selecting looking for me, working fine
$( function() {
	var Idmstate = false;
    var lookingForSt = true;
    var lookingForMeSt = false;
    $( "#lookingForMe" ).on( "click", function() {
        if ( lookingForSt && !lookingForMeSt) {
        	$( "#lookingForMe" ).animate({
                backgroundColor: "#008000",
                color: "#000"
              }, 100 ),lookingforflag.setAttribute('value', 0),document.body.appendChild(lookingforflag),
              lookingforMeflag.setAttribute('value',1),document.body.appendChild(lookingforMeflag),
              console.log(lookingforMeflag);
        } else { 
        	$( "#lookingForMe" ).animate({
                backgroundColor: "#33b5e5",
                color: "#FFF"
              }, 100 ),lookingforMeflag.setAttribute('value', 0),document.body.appendChild(lookingforMeflag),
              console.log(lookingforMeflag);
        }
        lookingForSt = !lookingForSt;
    	lookingForMeSt = !lookingForMeSt;
      }); 
});

// for making idmatch black when the down two are in green, but it is not working
$( function() {
    var lookingForVal = $( "#lookingforflag" ).val();
    var lookingForMeVal = $( "#lookingforMeflag" ).val();
    
    
    $( "#lookingForMe" ).on( "click", function() {
    	if((lookingForVal == 1) && (lookingForMeVal ==1)){
    		$( "#idmatch" ).animate({
    	        backgroundColor: "#008000",
    	        color: "#fff"
    	      }, 100 ),$( "#lookingFor" ).animate({
    	          backgroundColor: "#000000",
    	          color: "#fff"
    	        }, 100 ),$( "#lookingForMe" ).animate({
    	            backgroundColor: "#000000",
    	            color: "#fff"
    	          }, 1000 ), idmatchflag.setAttribute('value', 1),document.body.appendChild(idmatchflag),
    	          lookingforflag.setAttribute('value',0),
    	          lookingforMeflag.setAttribute('value',0),
    	          console.log(idmatchflag);
    	}
      });
});

/* to  */
