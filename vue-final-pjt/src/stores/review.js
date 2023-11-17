import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useReviewStore = defineStore('review', () => {
  const reviews = ref([])

  return { reviews, }
})
