<template>
    <form action="/">
        <van-search
                v-model="searchText"
                show-action
                placeholder="请输入搜索关键词"
                @search="onSearch"
                @cancel="onCancel"
        />
    </form>
    <van-divider content-position="left">已选标签</van-divider>
    <div v-if="activeIds.length === 0">请选择标签</div>
    <van-row gutter="20">
        <van-col v-for="tag in activeIds">
            <van-tag closeable size="medium" type="primary" @close="doClose(tag)">
                {{ tag }}
            </van-tag>
        </van-col>
    </van-row>
    <van-divider />
    <van-tree-select
            v-model:active-id="activeIds"
            v-model:main-active-index="activeIndex"
            :items="tagList"
    />
    <div style="padding: 20px">
        <van-button style="width: 100%" block type="primary" @click="doSearchResult">搜索</van-button>
    </div>
</template>

<script setup lang="ts">
import {ref} from 'vue';
import {useRouter} from "vue-router";

const router = useRouter();
const searchText = ref('');
const activeIds = ref([]);
const activeIndex = ref(0);
// 原始标签列表
const originTagList = [
    {
        text: '年级',
        children: [
            {text: '大一', id: '大一'},
            {text: '大二', id: '大二'},
        ],
    },
    {
        text: '性别',
        children: [
            {text: '男', id: '男'},
            {text: '女', id: '女'},
        ],
    },
];
// 展示用的标签列表
let tagList = ref(originTagList);
/**
 * 搜索过滤
 */
const onSearch = () => {
    tagList.value = originTagList.map(parentTag => {
        const tempChildren = [...parentTag.children];
        const tempParentTag = {...parentTag};
        tempParentTag.children = tempChildren.filter(item => item.text.includes(searchText.value));
        return tempParentTag;
    });
};
const onCancel = () => {
    searchText.value = '';
    tagList.value = originTagList;
}
// 删除标签
const doClose = (tag) => {
    activeIds.value = activeIds.value.filter(item => {
        return item !== tag;
    })
}
const doSearchResult = () => {
    router.push({
        path: 'user/list',
        query: {
            tags: activeIds.value
        }
    });
}

</script>

<style scoped>

</style>
