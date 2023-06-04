<template>
index页面
    <van-button type="primary" @click="onClick">跳转登录</van-button>
</template>

<script setup lang="ts">

import {useRouter} from "vue-router";

const router = useRouter();
const onClick = () => {
  router.push('user/login');
}
</script>

<style scoped>

</style>
