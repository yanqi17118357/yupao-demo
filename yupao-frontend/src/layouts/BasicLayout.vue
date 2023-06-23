<template>
    <van-nav-bar
            title="标题"
            left-arrow
            @click-left="onChangeLeft"
            @click-right="onChangeRight"
    >
        <template #right>
            <van-icon name="search" size="18"/>
        </template>
    </van-nav-bar>
    <!-- 公共布局，根据路由获取当前页面内容 -->
    <div id="content">
        <router-view />
    </div>
    <van-tabbar route>
        <van-tabbar-item to="/" icon="home-o" name="index">主页</van-tabbar-item>
        <van-tabbar-item to="/team" icon="friends-o" name="team">队伍</van-tabbar-item>
        <van-tabbar-item to="/user" icon="friends-o" name="user">个人</van-tabbar-item>
    </van-tabbar>
</template>

<script setup lang="ts">

import {useRouter} from "vue-router";

const router = useRouter();
const onChangeLeft = () => {
    router.back();
}
const onChangeRight = () => {
    router.push('/search');
}

</script>

<style scoped>
#content{
    padding-bottom: 50px;
}
</style>
