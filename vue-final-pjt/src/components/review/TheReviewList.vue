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

const route = useRoute();
const router = useRouter();
const reviews = ref([]);
const store = usePlaceStore();

const goReviewEdit = (review) => {
    return router.push({ name: 'reviewEdit', params: { review: review } });
}

const goReviewDelete = async (review) => {
    if (review.userId === JSON.parse(sessionStorage.getItem("user")).userId) {
        try {
            let URL = import.meta.env.VITE_APP_API_REVIEW_URL + "/" + store.reviewPlaceId + "/" + review.reviewId
            console.log(store.reviewPlaceId);
            console.log(review.reviewId);
            let response = await axios.delete(URL);
            URL = import.meta.env.VITE_APP_API_REVIEW_URL + "/" + route.params.placeId
            response = await axios.get(URL);
            reviews.value = response.data;
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