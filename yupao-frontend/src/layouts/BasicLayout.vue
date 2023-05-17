<template>
    <van-nav-bar
            title="标题"
            left-arrow
            @click-left="onClickLeft"
            @click-right="onClickRight"
    >
        <template #right>
            <van-icon name="search" size="18" />
        </template>
    </van-nav-bar>
    <div id="content">
        <template v-if="active === 'index'">
            <Index />
        </template>
        <template v-if="active === 'team'">
            <Team />
        </template>
    </div>
    <van-tabbar v-model="active" >
        <van-tabbar-item icon="home-o" name="index">主页</van-tabbar-item>
        <van-tabbar-item icon="friends-o" name="team">队伍</van-tabbar-item>
        <van-tabbar-item icon="friends-o" name="user">个人</van-tabbar-item>

    </van-tabbar>
</template>

<script setup lang="ts">
import {ref} from "vue";
import Index from "../pages/Index.vue";
import Team from "../pages/Team.vue";

const onClickLeft = () => alert("aaa");
const onClickRight = () => alert("bbb");
const active = ref("index");

</script>

<style scoped>

</style>