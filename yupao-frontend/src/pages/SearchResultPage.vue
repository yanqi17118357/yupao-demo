<template>
    <van-card
            v-for="user in userList"

            :tag=user.gender.toLocaleString()
            desc="描述信息"
            :title="`${user.username}（${user.planetCode}）`"
            :thumb="user.avatarUrl"
    >
        <template #tags>
            <van-tag style="margin-right: 5px; margin-top: 5px" plain type="primary" v-for="tag in user.tags">
                {{ tag }}
            </van-tag>
        </template>
        <template #footer>
            <van-button size="mini">联系我</van-button>
        </template>
    </van-card>
    <van-empty v-if="!userList || userList.length < 1" description="未查询到数据" />
</template>

<script setup>
import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";
import myAxios from '../plugins/myAxios.ts';
import qs from 'qs';
import {showFailToast, showSuccessToast, Toast} from "vant";

const userList = ref([]);
const route = useRoute();
const { tags } = route.query;

onMounted(async () => {
    const userListData = await myAxios.get('/user/search/tags', {
        params: {
            tagNameList: tags
        },
        paramsSerializer: params => {
            return qs.stringify(params, {indices: false})
        }
    })
        .then(function (response) {
            console.log('/user/search/tags succeed', response);
            showSuccessToast('请求成功');
            return response?.data;
        })
        .catch(function (error) {
            console.log('/user/search/tags error', error);
            showFailToast('请求失败');
        })
    console.log(userListData);
    if (userListData) {
        userListData.forEach(user => {
            if (user.tags) {
                user.tags = JSON.parse(user.tags);
            }
        })
        userList.value = userListData;
    }
})


</script>

<style scoped>

</style>
