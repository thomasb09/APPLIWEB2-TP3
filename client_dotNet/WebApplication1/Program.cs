using System;
using System.Net.Http;
using System.Threading.Tasks;

class Program
{
    static async Task Main()
    {
        string apiUrl = "http://172.20.45.21:8080/serviceREST-0.0.1-SNAPSHOT/routeDuJour"; // Replace with your API endpoint

        using (HttpClient client = new HttpClient())
        {
            try
            {
                // Make a GET request
                HttpResponseMessage response = await client.GetAsync(apiUrl);

                // Check if the request was successful
                if (response.IsSuccessStatusCode)
                {
                    // Read and print the content
                    string result = await response.Content.ReadAsStringAsync();
                    Console.WriteLine(result);

                    // Output the result in an HTML file
                    WriteResultToHtml(result);
                }
                else
                {
                    Console.WriteLine($"Error: {response.StatusCode}");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Exception: {ex.Message}");
            }
        }
    }

    static void WriteResultToHtml(string result)
    {
        // Write the result to an HTML file (output.html)
        System.IO.File.WriteAllText("output.html", $"<html><body><p>{result}</p></body></html>");
        Console.WriteLine("Result written to output.html");
    }
}