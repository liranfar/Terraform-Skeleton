# Terraform skeleton on AWS

## Usage
set up access and secret key in `credentials.tf` :
```bash
variable "aws_access_key" {
  description = "aws access key"
  default = "XXX" 
}
variable "aws_secret_key" {
  description = "aws_secret_key"
  default = "XXX" 
}
```

## How to run
```bash
terraform init
# terraform plan
terraform apply
```
## Verify
```bash
curl <public-ip-output>
Hello World
```


## References
* [Terraform Crash Course](https://www.youtube.com/watch?v=SLB_c_ayRMo)
* [Jenkins & Terraform Integration](https://www.youtube.com/watch?v=5jwYGCAr_pw)

## TODOs
1. create new github repo which contains only spring boot app with maven ( take it from jenkinsFile-helloWorld repo)
1. Create in that repo, jenkinsFile and teraform file for the deployment from jenkins
1. Divide the job to 2 main phases:
    - build, test ,create docker image and push to docker-registry/nexus
    - configure the teraform script to pull and run the docker image
1. Configure jenkins to install the terraform tool automatically ( low priority )
1. Install & run docker/docker-compose under ec2-user permissions ( currently everything runs on root )
