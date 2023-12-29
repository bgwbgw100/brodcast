let broadListAll;
let broadListAfreeca;
let broadListTwitch;
let broadListCopy;
let listIdx =0;

const broadUrl = { afreeca : "https://play.afreecatv.com/"
    ,twitch : "https://www.twitch.tv/"
}

window.onload = ()=>{
    document.querySelector(".content-table").innerHTML="";
    document.querySelectorAll(".platform").forEach(element => {
        element.addEventListener("click",fn_platform_tag_click);
    });

    document.querySelectorAll(".game").forEach(element => {
        element.addEventListener("click",fn_game_tag_click);
    });
    fn_set_broad_list();
    fn_scroll_event();
};

const fn_scroll_event = ()=>{
    window.addEventListener('scroll', function() {
        // 문서의 전체 높이
        var documentHeight = document.documentElement.scrollHeight;

        // 현재 스크롤 위치 (창의 높이와 현재 스크롤 위치를 더한 값)
        var currentScroll = window.innerHeight + window.scrollY;

        // 스크롤 위치가 전체 높이의 90%를 넘었는지 확인
        if (currentScroll / documentHeight > 0.9) {
            fn_more_list();
        }
    });

}

const fn_more_list = function (){

    fn_make_list(fn_get_broad_list_filter());

}


/**
 * 플랫폼 태그 클릭시 이벤트
 * 보이는 List 변경
 */
const fn_platform_tag_click = function(){
    const currentTarget = this;
    let tags = document.querySelectorAll(".platform");
    let isClassName = false;

    this.classList.forEach(className =>{
        isClassName = className === "click-color" ? true  : isClassName;
    })

    if (isClassName) return;

    for (const tag of tags) {
        tag.classList.remove("click-color")
    }
    currentTarget.classList.add("click-color");

    broadListCopy = fn_get_broad_list_filter();

    document.querySelector(".content-table").innerHTML="";
    listIdx = 0;

    fn_make_list(broadListCopy);
    fn_broad_tag_event();

    // 스크롤 이벤트 리스너 추가


}




/**
 * 게임 태그 클릭시 이벤트
 * 보이는 List 변경
 */
const fn_game_tag_click = function(){
    const currentTarget = this;
    let tags = document.querySelectorAll(".game");
    let isClassName = false;

    this.classList.forEach(className =>{
        isClassName = className === "click-color" ? true  : isClassName;
    })

    if (isClassName) return;

    for (const tag of tags) {
        tag.classList.remove("click-color")
    }
    currentTarget.classList.add("click-color");

    broadListCopy = fn_get_broad_list_filter();

    document.querySelector(".content-table").innerHTML="";
    listIdx = 0;

    fn_make_list(broadListCopy);
    fn_broad_tag_event();
}

/**
 * 태그에 맞춰 방송 목록을 filter 처리
 * @returns {Array}
 */
const fn_get_broad_list_filter = ()=>{
    let platFormStr =  document.querySelector(".platform-tag").querySelector(".click-color").innerText.toLowerCase();

    broadListCopy = platFormStr === "all" ? broadListAll.slice() : null;
    broadListCopy = platFormStr === "afreeca" ? broadListAfreeca.slice() : broadListCopy;
    broadListCopy = platFormStr === "twitch" ? broadListTwitch.slice() : broadListCopy;


    let tagStr = document.querySelector(".game-tag").querySelector(".click-color").dataset.tag.toLowerCase();
    return broadListCopy.filter( broadObj =>{
        if(tagStr === "all"){
            return true;
        }
        return  broadObj.tag.toLowerCase() === tagStr;
    }).slice();

}

/**
 * 서버에서 방송 리스트를 받아옴
 * @returns {Promise<any>}
 */
const fn_get_broad_list = ()=>{
    return  fetch("list").then(response => {
        return response.json();
    });
}
const fn_set_broad_list = async ()=>{
    const broadList = await fn_get_broad_list();
    broadListAll = broadList;
    broadListAfreeca = broadList.filter(detail=> detail.platForm === "afreeca" );
    broadListTwitch = broadList.filter(detail=> detail.platForm === "twitch" );
    fn_broad_list_sort(broadListAll,broadListAfreeca,broadListTwitch);

    broadListCopy = broadListAll.slice();
    fn_make_list(broadListCopy);
    fn_broad_tag_event();
}
const fn_broad_list_sort = (...broadListArr) =>{
    broadListArr.forEach(broadList => broadList.sort( (a,b) =>  b.views -a.views  ))
}

const fn_make_list = (broadList)=>{
    let tag = "";
    let idx = listIdx + 30;

    for ( listIdx ; listIdx < idx; listIdx++) {
        if(broadList[listIdx] === undefined) {
            break;
        }
        tag += `<div class="table-data">
                        <div class="table-platform">
                            <div class="text-platform ${fn_escape(broadList[listIdx].platForm)}">
                                ${fn_escape(broadList[listIdx].platForm)}
                            </div>
                        </div>
                        <div class="table-detail">
                            <div class="master-text text-ellipsis">
                                ${fn_escape(broadList[listIdx].name)}
                            </div>
                            <div class="title-text title-ellipsis">
                                <b>
                                    ${fn_escape(broadList[listIdx].title)}
                                </b>
                            </div>
                            <div class = "detail-text right-bottom">
                                 <div>아이디 : <span class = "user">${fn_escape(broadList[listIdx].userId)}</span> </div>
                                 <div>시청자수 : ${broadList[listIdx].views}명</div>
                            </div>
                        </div>
                    </div>`;
    }
    let content = document.querySelector(".content-table");
    content.insertAdjacentHTML("beforeend", tag);
}
const fn_escape = (str)=>{
    return str.replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/"/g, '&quot;')
        .replace(/'/g, '&#039;');
}

const fn_broad_tag_event = function (){
    document.querySelectorAll(".table-data").forEach(element =>{
        element.addEventListener("click",function (){
            const platForm = this.querySelector(".text-platform").innerText;
            const userId = this.querySelector(".user").innerText;
            window.open(broadUrl[platForm] + userId);
        })
    })
}
