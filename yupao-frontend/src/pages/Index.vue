<template>
    <UserCardList :user-list="userList" />
    <van-empty v-if="!userList || userList.length < 1" description="数据为空"/>
</template>

<script setup>
import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";
import myAxios from '../plugins/myAxios.ts';
import {showFailToast, showSuccessToast, Toast} from "vant";
import UserCardList from "../components/UserCardList.vue";

const userList = ref([]);
const route = useRoute();
const {tags} = route.query;

onMounted(async () => {
    // const userListData = await myAxios.get('/user/recommend2', {
    //     params: {},
    // })
    //     .then(function (response) {
    //         showSuccessToast('请求成功');
    //         return response?.data;
    //     })
    //     .catch(function (error) {
    //         showFailToast('请求失败');
    //     })
    //
    // if (userListData) {
    //     userListData.forEach(user => {
    //         if (user.tags) {
    //             user.tags = JSON.parse(user.tags);
    //         }
    //     })
    //     userList.value = userListData;
    // }
})

</script>

<style scoped>

</style>
