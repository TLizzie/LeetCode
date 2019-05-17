package foundation.array.ObjectOriented;

public class SingleDog {

    public String name = null;                                // 属性

    public String gender = null;

    public String job = null;

    public void work() {
        System.out.println("work");
    };                              // 行为

    public void play() {
        System.out.println("play");
    };

    public SingleDog() {
        System.out.println("我们都是单身狗");
//        this.name = "TL";
//        this.gender = "Female";
//        this.job = "Student";
    }

    public SingleDog(String name, String gender, String job){
        this.name = name;
        this.gender = gender;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
