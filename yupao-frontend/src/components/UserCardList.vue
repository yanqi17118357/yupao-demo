<template>
    <van-card
            v-for="user in null"

            :tag=user.gender.toLocaleString()
            desc="描述信息"
            :title="`${user.username}（${user.planetCode}）`"
            :thumb="user.avatarUrl?.toString()"
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
</template>

<script setup lang="ts">

import {UserType} from "../models/user";

interface UserCardListProps {
    userList: UserType[];
}

const props = withDefaults(defineProps<UserCardListProps>(), {
    userList: () => []
});

</script>

<style scoped>

</style>
