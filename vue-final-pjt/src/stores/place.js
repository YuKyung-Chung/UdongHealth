import { ref, computed,  } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';
export const usePlaceStore = defineStore('place', () => {

    const places = ref([]);

    const getPlaces = () => {
        const URL = import.meta.env.VITE_APP_API_URL;
        axios.get(URL)
            .then((response) => {
                console.log(response);
                places.value = response.data.items
            })
            .catch(() => { })
    }
    


    return { places, getPlaces, }
})
