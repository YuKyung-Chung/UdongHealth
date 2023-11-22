<template>
    <div>
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

                <td><button @click="goReviewEdit(review)" :reviewId="review.reviewId">수정</button></td>
                <td><button @click="goReviewDelete(review)" :reviewId="review.reviewId">삭제</button></td>
            </tr>
        </table>
    </div>
</template>

<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { usePlaceStore } from '../../stores/place';
import { useUserStore } from '../../stores/user';

const route = useRoute();
const router = useRouter();
const reviews = ref([]);
const userStore = useUserStore();
const placeStore = usePlaceStore();

const goReviewEdit = (review) => {
    if (userStore.loginTF === false) {
        alert("로그인을 먼저 해주세요")
        return router.push("/")

    } else if(review.userId !== JSON.parse(sessionStorage.getItem("user")).userId) {
        alert("본인이 작성한 리뷰만 수정 가능합니다.")
        return router.push("/")
    } 
    else {
        
        return router.push({ name: 'reviewEdit', params: { reviewId: review.reviewId, content : review.content } });
    }
}   

const goReviewDelete = async (review) => {
    if (review.userId === JSON.parse(sessionStorage.getItem("user")).userId) {
        try {
            let URL = import.meta.env.VITE_APP_API_REVIEW_URL + "/" + placeStore.reviewPlaceId + "/" + review.reviewId
            let response = await axios.delete(URL);
            URL = import.meta.env.VITE_APP_API_REVIEW_URL + "/" + route.params.placeId
            response = await axios.get(URL);
            reviews.value = response.data;
            alert("삭제 완료되었습니다.")
        } catch (error) {
            console.log(error);
        }
    } else {
        alert("본인이 작성한 리뷰만 삭제 가능합니다.")
    }
}

onMounted(async () => {
    let URL = import.meta.env.VITE_APP_API_REVIEW_URL + "/" + route.params.placeId
    const response = await axios.get(URL);
    reviews.value = response.data;
})

</script>

<style scoped></style>