import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

public class BurpExtensionInferenceExample {
    private static final String HF_API_TOKEN = "YOUR_HUGGING_FACE_API_TOKEN";
    private static final String MODEL_ID = "YOUR_MODEL_ID"; // e.g., "bert-base-uncased"
    
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        
        // Example input data from Burp Suite
        String inputData = "HTTP request or response data to analyze";
        
        // Create JSON payload
        String json = String.format("{\"inputs\": \"%s\"}", inputData);
        
        // Build request to Hugging Face Inference API
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-inference.huggingface.co/models/" + MODEL_ID))
            .header("Authorization", "Bearer " + HF_API_TOKEN)
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(json))
            .build();
        
        // Send request and get response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response from Hugging Face: " + response.body());
    }
    
    // Method to be used in Burp Extension
    public static String analyzeWithHuggingFace(String input) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String json = String.format("{\"inputs\": \"%s\"}", input);
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-inference.huggingface.co/models/" + MODEL_ID))
            .header("Authorization", "Bearer " + HF_API_TOKEN)
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(json))
            .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
