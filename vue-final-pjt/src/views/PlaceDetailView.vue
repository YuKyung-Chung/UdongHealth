<template>
    <div class="container">
        <div id="map2"></div>
        <div>
            <p>{{ place.addressGu + " " + place.addressDong + " " + place.공원명 }}</p>
            <!-- <TheReviewList /> -->
            <table border="1">
                <th>작성자</th>
                <th>내용</th>
                <th>조회수</th>
                <th></th>
                <th></th>
                <tr v-for="review in reviews" :key="review.reviewId">
                    <td>{{ review.writer }}</td>
                    <td>{{ review.content }}</td>
                    <td>{{ review.viewCnt }}</td>

                    <td><button @click="goReviewDetail(review.reviewId)" :placeId="place.placeId">수정</button></td>
                    <td><button @click="goReviewDelete(review.reviewId)" :placeId="place.placeId">삭제</button></td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script setup>
import axios from 'axios';
import { ref, onMounted, toRaw } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const place = ref({});
const reviews = ref([]);
const placeId = route.params.placeId;
let map = null;
const initMap = function () {
    let myCenter = new kakao.maps.LatLng(place.value.위도, place.value.경도); //공원위치

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position) => {
            const lat = position.coords.latitude;
            const lon = position.coords.longitude;
            myCenter = new kakao.maps.LatLng(lat, lon);
            new kakao.maps.Marker({
                map,
                position: myCenter,
            });
            map.setCenter(myCenter);
        });

    }
    const container = document.getElementById('map2');
    const options = {
        center: myCenter,
        level: 3,
    }; // 지도 객체를 등록합니다.
    map = new kakao.maps.Map(container, options);
    // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
    const mapTypeControl = new kakao.maps.MapTypeControl();

    // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
    const zoomControl = new kakao.maps.ZoomControl();
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
   
};


const myMarkerPosition = ref([
    [37.501286, 127.0396029],
])

const markers = ref([]);

const displayMarker = function (markerPositions) {
    //마커지우기
    if (markers.value.length > 0) {
        markers.value.forEach((marker) => marker.setMap(null));
    }

    const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
    );
    if (positions.length > 0) {
        markers.value = positions.map(
            (position) =>
                new kakao.maps.Marker({
                    map: toRaw(map),
                    position,
                })
        );

        const bounds = positions.reduce(
            (bounds, latlng) => bounds.extend(latlng),
            new kakao.maps.LatLngBounds()
        );

        toRaw(map).setBounds(bounds);
    }
};

onMounted(async () => {
    try {
        let URL = import.meta.env.VITE_APP_API_PLACE_URL + "/" + placeId;
        console.log(URL);
        const pResponse = await axios.get(URL);
        place.value = pResponse.data;
        URL = import.meta.env.VITE_APP_API_REVIEW_URL + "/" + place.value.placeId
        const rResponse = await axios.get(URL);
        reviews.value = rResponse.data;
        if (window.kakao && window.kakao.maps) {
            initMap();
        } else {
            const script = document.createElement('script'); // autoload=false 스크립트를 동적으로 로드하기 위해서 사용
            script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${import.meta.env.VITE_APP_MAP_API_KEY
                }`;
            script.addEventListener('load', () => {
                kakao.maps.load(initMap);
            }); //헤드태그에 추가
            document.head.appendChild(script);
        }


    } catch (error) {
        console.log(error);
    };

})

function addMarker(position) {
    // 마커를 생성합니다
    let marker = new kakao.maps.Marker({
        position: position
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

    // 생성된 마커를 배열에 추가합니다
    markers.value.push(marker);
}


</script>

<style  scoped>
#map2 {
    width: 60%;
    height: 70vh;
}

.container {
    display: flex;
}
</style>