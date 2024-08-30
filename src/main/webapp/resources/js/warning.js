window.addEventListener('keydown', function(e) {
    if (
        // CMD + Alt + I (Chrome, Firefox, Safari)
        e.metaKey == true && e.altKey == true && e.keyCode == 73 ||
        // CMD + Alt + J (Chrome)
        e.metaKey == true && e.altKey == true && e.keyCode == 74 ||
        // CMD + Alt + C (Chrome)
        e.metaKey == true && e.altKey == true && e.keyCode == 67 ||
        // CMD + Shift + C (Chrome)
        e.metaKey == true && e.shiftKey == true && e.keyCode == 67 ||
        // Ctrl + Shift + I (Chrome, Firefox, Safari, Edge)
        e.ctrlKey == true && e.shiftKey == true && e.keyCode == 73 ||
        // Ctrl + Shift + J (Chrome, Edge)
        e.ctrlKey == true && e.shiftKey == true && e.keyCode == 74 ||
        // Ctrl + Shift + C (Chrome, Edge)
        e.ctrlKey == true && e.shiftKey == true && e.keyCode == 67 ||
        // F12 (Chome, Firefox, Edge)
        e.keyCode == 123 ||
        // CMD + Alt + U, Ctrl + U (View source: Chrome, Firefox, Safari, Edge)
        e.metaKey == true && e.altKey == true && e.keyCode == 85 ||
        e.ctrlKey == true && e.keyCode == 85
    ) {
		e.preventDefault();
		return false;
    }
});

$(document).ready(function(){
	//마우스 우측 버튼 사용 막기.
	if (window.addEventListener) {
		window.addEventListener('contextmenu', function(e) { try { if (typeof e != 'undefined') { e.preventDefault(); return false; } else { return false; }} catch(e) {} } , false);
	} else {
		window.attachEvent('oncontextmenu', function(e) { try { if (typeof e != 'undefined') { e.preventDefault(); return false; } else { return false; }} catch(e) {} } );
	}
	var handlemouseEvent = function(e) {
		try {
			if (typeof e == 'undefined') {
				if (window.event.button && window.event.button == "2") {
					return false;
				}
			} else if ((e.which && e.which == 3) || (e.button && e.button == 2)) {
				e.preventDefault();
				return false;
			}
	
		} catch (e) {}
	};
	window.onkeydown = handlemouseEvent;
	window.onkeyup = handlemouseEvent;
    
	//로그아웃 시켜버릴 임시 form 생성
	var logOutFrom = document.createElement('form');
	logOutFrom.name= "logOutFrom";
	logOutFrom.id= "logOutFrom";
	logOutFrom.action = ctx+"/logout";
	logOutFrom.method= "POST";
	var input = document.createElement('input');
	input.type = 'hidden';
	input.name = '${_csrf.parameterName}';
	input.value = '${_csrf.token}';
	logOutFrom.appendChild(input);
	document.body.appendChild(logOutFrom);

    //개발자도구 실행 감지.
    console.log(Object.defineProperties(new Error, {
        toString: {value() {(new Error).stack.includes('toString@') && alert('Safari devtools')}},
        message: {
            get() {
                //개발자도구를 감지하면 그냥 홬 로갓 키겨 버리자.
                logOutFrom.submit()
        	}
        },
    }));

 });