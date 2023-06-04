<template>
    <template v-if="user">
        <van-cell title="用户名" is-link to="/user/edit" :value="user.username"/>
        <van-cell title="账号" :value="user.userAccount" />
        <van-cell title="头像" is-link to="/user/edit">
            <img style="height: 48px" src="https://npm.elemecdn.com/yanqi1711-picx@1.0.11/img/me.webp" alt="头像">
        </van-cell>
        <van-cell title="性别" is-link to="/user/edit" :value="user.gender" @click="toEdit('gender','性别',user.gender)"/>
        <van-cell title="电话" is-link to="/user/edit" :value="user.phone" />
        <van-cell title="邮箱" is-link to="/user/edit" :value="user.email" />
        <van-cell title="星球编号" is-link to="/user/edit" :value="user.planetCode" />
        <van-cell title="注册时间" :value="user.createTime" />
    </template>
</template>

<script setup lang="ts">
import {useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import myAxios from "../plugins/myAxios.js";
import {showFailToast, showSuccessToast} from "vant";

// const user = {
//     id: 1,
//     username: '测试',
//     userAccount: 'doge',
//     avatarUrl: 'https://npm.elemecdn.com/yanqi1711-picx@1.0.11/img/me.webp',
//     phone: '12345678900',
//     gender: '男',
//     email: '123456789@qq.com',
//     planetCode: '1',
//     createTime: new Date().toLocaleDateString(),
// }

const user = ref({});

onMounted(async () => {
    const res = await myAxios.get('user/current');
    if (res.code === 0) {
        user.value = res.data;
        showSuccessToast('获取用户信息成功');
    }else {
        showFailToast('获取用户信息失败');
    }
})

const router = useRouter();
const toEdit = (editKey: string, editName: string, currentValue: string) => {
    router.push({
        path: '/user/edit',
        query: {
            editKey,
            editName,
            currentValue,
        }
    })
}
</script>

<style scoped>

</style>
