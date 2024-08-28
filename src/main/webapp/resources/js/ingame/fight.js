// 펫 이미지
const petImg = document.getElementById("petImg");
const enemyImg = document.getElementById("enemyImg")

// 펫 무기 이미지
const weaponImg = document.getElementById("weaponImg");
const enemyWeaponImg = document.getElementById("enemyWeaponImg");

// 펫 대사
const line = document.getElementById("line");
const enemyLine = document.getElementById("enemyLine");

// 대사 감싼 div
const lineParent = document.getElementById("lineParent");
const lineEnemyParent = document.getElementById("lineEnemyParent");

// 싸우기 버튼
const fightBtn = document.getElementById("fightBtn");
const clickMe = document.getElementById("clickMe");

// 싸우기 종료 모달
const fightResultImg = document.getElementById("fightResultImg");
const doneBtn = document.getElementById("done");
const modalImg = document.getElementById("modalImg");
let h4One = document.createElement("h4"); //모달 안 하단 텍스트
const checkBtn = document.getElementById("check");
const goHome = document.getElementById("goHome");

const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]')
const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))

//함수로 fetch만들어서 

fightBtn.addEventListener("click", ()=>{
    lineParent.style.display="none";
    lineEnemyParent.style.display="none";
    fightBtn.remove();
    clickMe.remove();
    petImg.style.cursor="pointer";
})



let currentDroppable = null;

weaponImg.addEventListener("mousedown", (e)=>{
    let x = e.clientX - weaponImg.getBoundingClientRect().left;
    let y = e.clientY - weaponImg.getBoundingClientRect().top;

    moveAt(e.pageX, e.pageY);

    function moveAt(pageX, pageY) {
        weaponImg.style.left = pageX - x + 'px';
        weaponImg.style.top = pageY - y + 'px';
     }

     function onMouseMove(event) {
        moveAt(event.pageX, event.pageY);
     
        weaponImg.hidden = true;
        //좌표를 element로 가져오기
        let elemBelow = document.elementFromPoint(event.clientX, event.clientY);
        weaponImg.hidden = false;
     
        
        if (!elemBelow) return;
     
        //elemen에에서가장장 가까운 조상 찾아서 droppable 클래스 넣기
        let droppableBelow = elemBelow.closest('.droppable');
       
        if (currentDroppable != droppableBelow) {
           if (currentDroppable) { 
              
              leaveDroppable(currentDroppable);
           }
           currentDroppable = droppableBelow;
           if (currentDroppable) { 
              enterDroppable(currentDroppable);
              
              
           }
        }
    }
        document.addEventListener('mousemove', onMouseMove);
       
        weaponImg.onmouseup = function () {
           document.removeEventListener('mousemove', onMouseMove);
           weaponImg.onmouseup = null;
        };
     
     })


function enterDroppable(elem) {
 elem.style.background = 'pink';
 lineEnemyParent.style.display="inline";
 lineEnemyParent.style.backgroundColor="red";
 enemyLine.innerHTML="으악!";
 enemyLine.style.color="white";

}

function leaveDroppable(elem) {
 elem.style.background = '';
}

weaponImg.ondragstart = function () {
 return false;
};

let mypet_num = fightResultImg.getAttribute("data-mypet-num");
let enemypet_num = fightResultImg.getAttribute("data-enemypet-num");


enemyImg.addEventListener("click", ()=>{
   fightResultImg.src = "/resources/img/ingame/fight.gif"
   h4One.innerHTML = "싸우는 중...";
   modalImg.append(h4One);
   checkBtn.style.display = "none";
   goHome.style.display="none";
   
   setTimeout(()=>{
      checkBtn.style.display = "inline";
      
   }, 1500)

  
})

checkBtn.addEventListener("click", ()=>{

   fetch("./fightResult?pet_num=" + mypet_num + "&record_enemy_num=" + enemypet_num, {
      method:"GET"
   })
   .then((res)=>{return res.text()})
   .then((res) =>{
      if(res == 1) {
         fightResultImg.src = "/resources/img/ingame/victory.gif"
         h4One.innerHTML = "승리를 축하드려요";
         modalImg.append(h4One);
         checkBtn.style.display = "none";
         goHome.style.display="inline";
         
      } else if (res == 0) {
         fightResultImg.src = "/resources/img/ingame/lose.gif"
         h4One.innerHTML = "패배했어요";
         modalImg.append(h4One);
         checkBtn.style.display = "none";
         goHome.style.display="inline";
      } else {
         fightResultImg.src = "/resources/img/ingame/draw.gif"
         h4One.innerHTML = "비겼어요";
         modalImg.append(h4One);
         checkBtn.style.display = "none";
         goHome.style.display="inline";
      }
   })
})


// doneBtn.addEventListener("click", ()=>{

//    // alert("heyyyy");
//    // location.href = "./ingame";
// })
