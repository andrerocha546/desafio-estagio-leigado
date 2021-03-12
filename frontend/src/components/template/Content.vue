<template>
    <div class="content">
        <Form />
    </div>
</template>

<script>
import Form from '@/components/form/Form'

export default {
    name: 'Content',
    components: { Form }
}
</script>

<style>
    .content {
        grid-area: content;
        background-color: #efefef;
        padding: 20px
    }
</style>