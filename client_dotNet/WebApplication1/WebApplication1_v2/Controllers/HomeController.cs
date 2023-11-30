using System;
using System.IO;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

public class HomeController : Controller
{
    public async Task<IActionResult> Index()
    {
        string apiUrl = "http://172.20.45.21:8080/serviceREST-0.0.1-SNAPSHOT/routeDuJour";

        using (HttpClient client = new HttpClient())
        {
            try
            {
                HttpResponseMessage response = await client.GetAsync(apiUrl);

                if (response.IsSuccessStatusCode)
                {
                    string result = await response.Content.ReadAsStringAsync();

                    // Write the result to an HTML file
                    WriteResultToHtml(result);

                    ViewBag.Result = result;
                }
                else
                {
                    ViewBag.Error = $"Error: {response.StatusCode}";
                }
            }
            catch (Exception ex)
            {
                ViewBag.Error = $"Exception: {ex.Message}";
            }
        }

        return View();
    }

    private void WriteResultToHtml(string result)
    {
        // Write the result to an HTML file (output.html)
        string filePath = Path.Combine(Directory.GetCurrentDirectory(), "wwwroot", "output.html");
        System.IO.File.WriteAllText(filePath, $"<html><body><p>{result}</p></body></html>");
    }
}
