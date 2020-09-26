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