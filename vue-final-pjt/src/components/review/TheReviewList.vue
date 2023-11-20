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

                <td><button @click="goReviewEdit(review.reviewId)" :reviewId="review.reviewId">수정</button></td>
                <td><button @click="goReviewDelete(review.reviewId)" :reviewId="review.reviewId">삭제</button></td>
            </tr>
        </table>
    </div>
</template>

<script setup>
import axios from 'axios';
import {ref, onMounted} from 'vue';
import {useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();
const reviews = ref([]); 

const goReviewEdit = (reviewId) => {
    return router.push({name: 'reviewEdit', params: {reviewId : reviewId}});
}

onMounted(async () => {
    let URL = import.meta.env.VITE_APP_API_REVIEW_URL + "/" + route.params.placeId
    const response = await axios.get(URL);
    reviews.value = response.data;
})

</script>

<style scoped></style>