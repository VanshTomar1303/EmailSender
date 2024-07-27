import { customAxios } from "./helper";

export async function sendEmail(emailData){
   const result = (await customAxios.post(`/email/send`,emailData)).data
   
   return result;
}
export async function sendWithFile(formData) {
   const result = (await customAxios.post(`/email/send-with-file`, formData, {
       headers: {
           'Content-Type': 'multipart/form-data'
       }
   })).data;
   return result;
}