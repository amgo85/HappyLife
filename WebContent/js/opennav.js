var nav_st = 0;

function openNav() {
	
	
	if(nav_st == 1){
		nav_st = 0;
		closeNav() ;
		return 0 
	}
	
	nav_st = 1
    document.getElementById("mySidenav").style.width = "250px";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
    document.getElementById("nav_title").style.color = "rgba(255,255,0,1)";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.body.style.backgroundColor = "white";
    document.getElementById("nav_title").style.color = "rgba(255,255,255,1)";
}