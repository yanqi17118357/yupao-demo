<template>
    <van-address-edit
            :area-list="areaList"
            show-delete
            show-set-default
            show-search-result
            :search-result="searchResult"
            :area-columns-placeholder="['1', '2', '3']"
            @save="onSave"
            @delete="onDelete"
            @change-detail="onChangeDetail"
    />
</template>

<script setup lang="ts">
import {ref} from 'vue';
import {showToast} from 'vant';

const searchResult = ref([]);
const areaList= ref();

const onSave = () => showToast('save');
const onDelete = () => showToast('delete');
const onChangeDetail = (val) => {
    if (val) {
        searchResult.value = [
            {
                name: '黄龙万科中心',
                address: '杭州市西湖区',
            },
        ];
    } else {
        searchResult.value = [];
    }
};


</script>

<style scoped>

</style>
