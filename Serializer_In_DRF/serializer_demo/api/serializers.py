from rest_framework import serializers
from .models import Student

# create serializer class for read model
class StudentSerializer(serializers.Serializer):
    id = serializers.IntegerField()
    name = serializers.CharField(max_length=100)
    roll_no = serializers.IntegerField()
    city = serializers.CharField(max_length=100)
    created_at = serializers.DateField()



# create serializer class for create model
class StudentSerializerCreate(serializers.Serializer):
    name = serializers.CharField(max_length=100)
    roll_no = serializers.IntegerField()
    city = serializers.CharField(max_length=100)
    created_at = serializers.DateField()

    def create(self, validated_data):
        return Student.objects.create(**validated_data)

# create serializer class for update model
class StudentSerializerUpdate(serializers.Serializer):
    name = serializers.CharField(max_length=100)
    roll_no = serializers.IntegerField()
    city = serializers.CharField(max_length=100)
    created_at = serializers.DateField()

    def update(self, instance, validated_data):
        instance.name = validated_data.get('name',instance.name)
        instance.roll_no = validated_data.get('roll_no',instance.roll_no)
        instance.city = validated_data.get('city',instance.city)
        instance.created_at = validated_data.get('created_at',instance.created_at)
        instance.save()
        return instance

# create serializer class for delete model
class StudentSerializerDelete(serializers.Serializer):
    name = serializers.CharField(max_length=100)
    roll_no = serializers.IntegerField()
    city = serializers.CharField(max_length=100)
    created_at = serializers.DateField()

    def delete(self, validated_data):
        return Student.objects.create(**validated_data)