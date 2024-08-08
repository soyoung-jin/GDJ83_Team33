const feed = document.getElementById("feed");
const stroll = document.getElementById("stroll");
const clean = document.getElementById("clean");
const modalActLabel = document.getElementById("modalActLabel");
const actImg = document.getElementById("actImg");
const actCloseBtn = document.getElementById("actCloseBtn");


function closePet(){
    actCloseBtn.click();
}



feed.addEventListener("click", ()=>{
    
    fetch("./feed", {
        method: "GET"
    })
    .then(r=>r.text())
    .then((r)=>{
        r.trim();
        if(r>0) {
            modalActLabel.innerHTML = "식사 중";
            actImg.src = "/resources/img/petAct/feed.gif";
            setTimeout(closePet, 1500);
            alert("포만감이 올라갔어요");
            location.href = "./ingame";
            
        }
    })
    .catch(()=>{
        alert("오류");
    })
    


})

stroll.addEventListener("click", ()=>{

    fetch("./stroll", {
        method: "GET"
    })
    .then(r=>r.text())
    .then((r)=>{
        r.trim()
        if(r>0) {
            modalActLabel.innerHTML = "산책 중";
            actImg.src = "/resources/img/petAct/stroll.gif";
            setTimeout(closePet, 1500);
            alert("경험치가 올라갔어요");
            location.href = "./ingame";
            
        }
    })
    .catch(()=>{
        alert("오류");
    })

    
})

clean.addEventListener("click", ()=>{

    fetch("./stroll", {
        method: "GET"
    })
    .then(r=>r.text())
    .then((r)=>{
        r.trim()
        if(r>0) {
            modalActLabel.innerHTML = "청소 중";
            actImg.src = "/resources/img/petAct/clean.gif";
            setTimeout(closePet, 1500);
            alert("경험치가 올라갔어요");
            location.href = "./ingame";
            
        }
    })
    .catch(()=>{
        alert("오류");
    })
    
})






