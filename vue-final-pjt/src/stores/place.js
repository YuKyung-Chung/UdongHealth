import { ref, computed, } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';
export const usePlaceStore = defineStore('place', () => {

    const places = ref([]);

    const getPlaces = async () => {
        try {
            const URL = import.meta.env.VITE_APP_API_PLACE_URL;
            const response = await axios.get(URL);
            places.value = response.data;
        } catch (error) {
            console.log(error);
        }
    };



    return { places, getPlaces, }
})
